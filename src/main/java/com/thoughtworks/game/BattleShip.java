package com.thoughtworks.game;

import com.thoughtworks.game.exception.InvalidShipDimensionsException;
import com.thoughtworks.game.exception.InvalidShipTypeException;


public class BattleShip extends Ship {
	
	BattleShip(int minWidth, int maxWidth, char minHeight, char maxHeight){
		this.minWidth = minWidth;
		this.maxWidth = maxWidth;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
	}
	
	public Ship createShip(String type, int width, int height){
		this.width = width;
		this.height = height;
		if (width < minWidth || width > maxWidth) {
			throw new InvalidShipDimensionsException("Invalid Battle Ship Size: width[" + width + "], " + " Width must be between(inclusive) " + minWidth + " and " + maxWidth);
		}
		if (height < minHeight-64 || height > maxHeight-64) {
			throw new InvalidShipDimensionsException("Invalid Battle Ship Size: height[" + height + "]. Height must be between(inclusive) " + minHeight + " and " + maxHeight);
		}
		this.type = type;
		boolean isShipTypeValid = false;
		for (ShipType shipType: ShipType.values()) {
			if(shipType.name().equals(type)){
				isShipTypeValid = true;
				break;
			}
		}
		if(!isShipTypeValid){
			throw new InvalidShipTypeException("Invalid Ship Type [" + type + "]. Expected " + ShipType.values());
		}
		
		return this;
	}
	
	public int getStrength(String type){
		return ShipType.valueOf(type).getStrength();
	}
}
