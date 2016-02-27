package com.github.mysqlbinlog.common.model.event.extra;

import java.util.Arrays;


public class BlobColumn extends Column {
	private static final long serialVersionUID = -3913839314388589671L;
	private final byte[] value;

	public BlobColumn(int type, byte[] value) {
		super(type);
		this.value = value;
	}

	@Override
	public byte[] getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "BlobColumn [value=" + Arrays.toString(value) + "]";
	}
}