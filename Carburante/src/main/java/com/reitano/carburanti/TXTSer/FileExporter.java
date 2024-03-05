package com.reitano.carburanti.TXTSer;

import java.nio.file.Path;

public interface FileExporter {
	public Path export(String fcontent, String fname);
}
