package com.lujianfei.bluetooth.parses;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class Commander {
	private OutputStream outputStream;
	private InputStream inputStream;
	protected synchronized OutputStream getOutputStream() {
		return outputStream;
	}
	protected void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	protected synchronized InputStream getInputStream() {
		return inputStream;
	}
	protected void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public abstract void execute() throws IOException;
	public abstract void stop();
}
