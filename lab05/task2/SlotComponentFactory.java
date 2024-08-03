public interface SlotComponentFactory {
	public Cabinet createCabinet(String cabi);
	public Payment createPayment(String pay);
    public Display createDisplay(String disp);
	public GPU createGPU(String gp);
	public OS createOS(String o);
	
}
