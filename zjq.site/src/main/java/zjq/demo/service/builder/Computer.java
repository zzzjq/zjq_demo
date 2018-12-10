package zjq.demo.service.builder;

/**
 * 建造者
 * 
 * @author zhangjq
 * @date 2018年12月10日下午8:02:07
 *
 **/
public class Computer {

	private Computer() {
	}

	private Object cpu;

	private Object ram;

	private Object gpu;

	public Object getCpu() {
		return cpu;
	}

	public Object getRam() {
		return ram;
	}

	public Object getGpu() {
		return gpu;
	}

	private Computer(Computer_builder builder) {
		this.cpu = builder.cpu;
		this.ram = builder.ram;
		this.gpu = builder.gpu;
	}

	public static Computer_builder builder() {
		return new Computer_builder();
	}

	private static class Computer_builder {
		private Object cpu;

		private Object ram;

		private Object gpu;

		public Computer_builder setCpu(Object cpu) {
			this.cpu = cpu;
			return this;
		}

		public Computer_builder setRam(Object ram) {
			this.ram = ram;
			return this;
		}

		public Computer_builder setGpu(Object gpu) {
			this.gpu = gpu;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}
	}

	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", ram=" + ram + ", gpu=" + gpu + "]";
	}

	public static void main(String[] args) {
		Computer c = Computer.builder().setCpu("i7").setGpu("GTX1060-6G").setRam("32G").build();
		System.out.println(c.toString());
	}

}
