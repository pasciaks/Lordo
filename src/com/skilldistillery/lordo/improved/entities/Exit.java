package com.skilldistillery.lordo.improved.entities;

import java.util.UUID;

public class Exit {

	private UUID id; // 067e6162-3b6f-4ae2-a171-2470b63dff00 (exit id)
	private String direction; // "North" ( N, S, E, W, U, D )
	private UUID destinationId; // 54947df8-0e9e-4471-a2f9-9af509fb5889 (location id)

	public Exit() {
		super();
	}

	public Exit(String direction, UUID destinationId) {
		super();
		this.id = UUID.randomUUID();
		this.direction = direction;
		this.destinationId = destinationId;
	}

}
