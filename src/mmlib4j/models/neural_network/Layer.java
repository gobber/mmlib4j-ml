package mmlib4j.models.neural_network;

import mmlib4j.models.datastruct.Matrix;
import mmlib4j.models.transfer.Transfer;

public class Layer {
	
	private Transfer transfer;
	private Matrix weigths;
	private Matrix bias;
	
	public Layer(Transfer transfer, Matrix weigths, Matrix bias) {
		this.transfer = transfer;
		this.weigths = weigths;
		this.bias = bias;
	}
	
	public Layer(Transfer transfer) {
		this.transfer = transfer;
	}
	
	public Matrix activate(Matrix matrix) {
		return transfer.activate(matrix);	
	}
	
	public Transfer getTransfer() {
		return transfer;
	}
	
	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}

	public Matrix getWeigths() {
		return weigths;
	}

	public void setWeigths(Matrix weigths) {
		this.weigths = weigths;
	}

	public Matrix getBias() {
		return bias;
	}

	public void setBias(Matrix bias) {
		this.bias = bias;
	}

}
