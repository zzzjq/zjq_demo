package zjq.demo.service.facade;
/**
 * @author:zhangjq
 * @time:2017年4月18日 下午4:13:07
 * @version:v1.0
 */
public class Computer implements AbstractFacade{

	private Cpu cpu;
	
	private Memory memory;
	
	private Disk disk;
	
	public Computer(){
		super();
	}
	
	//构造器注入
	public Computer(Cpu cpu, Memory memory, Disk disk){
		this.cpu = cpu;
		this.memory = memory;
		this.disk = disk;
	}

	@Override
	public void open() {
		cpu.open();
		memory.open();
		disk.open();
	}

	@Override
	public void shutDown() {
		cpu.shutDown();
		memory.shutDown();
		disk.shutDown();
	}
	
}
