package kr.co.ch02.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class Tv {
	
	@Autowired
	private Speaker spk;

	@Autowired
	private Remocon remocon;
	
	public Tv(Speaker spk, Remocon remocon) {
		this.spk = spk;
		this.remocon = remocon;
	}
		
	public void powerOn() {
		remocon.powerOn();
	}
	public void powerOff() {
		remocon.powerOff();
	}
	public void chUp() {
		remocon.chUp();
	}
	public void chDown() {
		remocon.chDown();
	}
	public void soundUp() {
		spk.soundUp();
	}
	public void soundDown() {
		spk.soundDown();
	}
}
