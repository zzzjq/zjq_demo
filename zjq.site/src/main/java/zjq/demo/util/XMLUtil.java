/**
 * 
 */
package zjq.demo.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.springframework.util.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author pony
 * 
 */
public class XMLUtil {

	private Node rootNode;

	private Document doc;

	private String xmlStr;

	public XMLUtil(String xmlStr) {
		this.xmlStr = xmlStr;
		initWithXmlStr();
	}

	/**
	 * @return Returns the doc.
	 */
	public Document getDoc() {
		return doc;
	}

	public void initWithXmlStr() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder build = factory.newDocumentBuilder();
			doc = build.parse(new ByteArrayInputStream(this.xmlStr
					.getBytes("UTF-8")));
			rootNode = doc;
			// doc = doc.getFirstChild();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String inputstream2xml(InputStream io) {

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(io);
			return xml2Str(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String xml2Str(Document document) {

		try {
			DOMSource source = new DOMSource(document);
			StringWriter writer = new StringWriter();
			Result result = new StreamResult(writer);
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS,
					"yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(source, result);
			return (writer.getBuffer().toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public static Document str2Xml(String xmlStr)
			throws ParserConfigurationException, SAXException, IOException {

		StringReader sr = new StringReader(xmlStr);
		InputSource is = new InputSource(sr);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(is);
		return doc;

	}

	public String getProperty(String key) {
		int index = key.lastIndexOf('.');
		String propertyName = key.substring(index + 1);
		Node node = getNode(key, false);
		if (node == null) {
			return "";
		}
		NamedNodeMap attrs = node.getAttributes();
		Node attr = attrs.getNamedItem(propertyName);
		if (attr == null) {
			return "";
		}
		return attr.getNodeValue();
	}

	public String getValue(String key) {
		Node node = getNode(key, true);
		if (node == null) {
			return "";
		}
		Node temp = node.getFirstChild();
		if (null == temp) {
			return "";
		} else {
			return temp.getNodeValue();
		}
	}

	public Node getNode(String key, boolean isGetValue) {
		StringTokenizer st = new StringTokenizer(key, ".");
		Node currentNode = rootNode;
		Node preNode = null;
		int count = st.countTokens();
		for (int i = 0; i < count; i++) {
			if (null == currentNode) {
				return null;
			}
			if (!isGetValue && i == count - 1) {
				return currentNode;
			}
			preNode = currentNode;
			String nodeName = (String) st.nextElement();
			NodeList nodes = currentNode.getChildNodes();
			int len = nodes.getLength();
			for (int j = 0; j < len; j++) {
				Node node = nodes.item(j);
				if (nodeName.equalsIgnoreCase(node.getNodeName())) {
					currentNode = node;
					break;
				}
			}
			if (currentNode == preNode) {
				return null;
			}
		}

		return currentNode;
	}

	public void setNodeValue(String key, String value) {
		Node node = getNode(key, true);
		Assert.notNull(node, "node must be not null");
		Assert.notNull(value, "node's value must be not null");
		if (node.hasChildNodes())
			node.getFirstChild().setNodeValue(value);
		else
			node.appendChild(doc.createTextNode(value));

	}

	public static String replace(String xml, Map value) {
		int len = xml.length();
		StringBuffer buf = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			char c = xml.charAt(i);
			if (c == '$') {
				i++;
				StringBuffer key = new StringBuffer();
				char temp = xml.charAt(i);
				while (temp != '}') {
					if (temp != '{') {
						key.append(temp);
					}
					i++;
					temp = xml.charAt(i);
				}
				String variable = (String) value.get(key.toString());
				if (null == variable) {
					buf.append("");
				} else {
					buf.append(variable);
				}
			} else {
				buf.append(c);
			}
		}
		return buf.toString();
	}

	public static Map< String, Object > xml2map( String xmlStr ) throws DocumentException
	{
		org.dom4j.Document doc = DocumentHelper.parseText( xmlStr );
		return ( Map< String, Object > ) xml2map( doc.getRootElement( ) );
	}

	public static Map< String, Object > xml2map( org.dom4j.Element root )
	{
		Map< String, Object > map = new HashMap< String, Object >( );
		List< org.dom4j.Element > elements = root.elements( );
		if ( elements.size( ) == 0 )
		{
			map.put( root.getName( ), root.getText( ) );
			if ( !root.isRootElement( ) )
			{
				return map;
			}
		}
		else if ( elements.size( ) == 1 )
		{
			org.dom4j.Element element = elements.get( 0 );
			if ( element.isTextOnly( ) )
			{
				map.put( element.getName( ), element.getTextTrim( ) );
			}
			else
			{
				map.put( element.getName( ), xml2map( element ) );
			}
		}
		else if ( elements.size( ) > 1 )
		{
			// 多个子节点的话就得考虑list的情况了，比如多个子节点有节点名称相同的
			// 构造一个map用来去重
			Map< String, org.dom4j.Element > tempMap = new HashMap< String, org.dom4j.Element >( );
			for ( org.dom4j.Element ele : elements )
			{
				tempMap.put( ele.getName( ), ele );
			}
			Set< String > keySet = tempMap.keySet( );
			for ( String string : keySet )
			{
				org.dom4j.Namespace namespace = tempMap.get( string ).getNamespace( );
				List< org.dom4j.Element > elements2 = root.elements( new org.dom4j.QName(
						string, namespace ) );
				// 如果同名的数目大于1则表示要构建list
				if ( elements2.size( ) > 1 )
				{
					List< Object > list = new ArrayList< Object >( );
					for ( org.dom4j.Element ele : elements2 )
					{
						list.add( xml2map( ele ) );
					}
					map.put( string, list );
				}
				else
				{
					// 同名的数量不大于1则直接递归去
					org.dom4j.Element element = elements2.get( 0 );
					if ( element.isTextOnly( ) )
					{
						map.putAll( xml2map( element ) );
					}
					else
					{
						map.put( element.getName( ), xml2map( element ) );
					}
				}
			}
		}

		return map;
	}

	public static void main(String[] args) throws Exception {
		
	}
}
