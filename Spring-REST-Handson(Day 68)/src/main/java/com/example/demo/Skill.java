package com.example.demo;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.lang.NonNull;

public class Skill {
	@NonNull
	@NumberFormat
	private int skillId;
	@NonNull
	private String skillName;
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + "]";
	}
	
}


