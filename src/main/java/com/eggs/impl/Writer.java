package com.eggs.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.eggs.Foods;
import com.eggs.Restor;

public class Writer {
	
	private void maker() {
		
		Restor restor1 = new Restor();
		Restor restor2 = new Restor();
		
		restor1.setname("Karesz");
		restor2.setname("Marcello");
		
		Foods foods1 = new Foods();
		Foods foods2 = new Foods();
		Foods foods3 = new Foods();
		Foods foods4 = new Foods();
		Foods foods5 = new Foods();
		Foods foods6 = new Foods();
		
		
		foods1.setDesc("Hagymas Rantotta");
		foods1.setId("k1");
		foods1.setPrice(450);
		
		foods2.setDesc("Ham and Eggs");
		foods2.setId("k2");
		foods2.setPrice(540);

		foods3.setDesc("Kroasszon");
		foods3.setId("k3");
		foods3.setPrice(320);
		
		foods4.setDesc("Margherita");
		foods4.setId("m1");
		foods4.setPrice(250);
		
		foods5.setDesc("Grilled Cat");
		foods5.setId("m2");
		foods5.setPrice(890);
		
		foods6.setDesc("Ostriga");
		foods6.setId("m3");
		foods6.setPrice(1490);
		
		List<Foods> foodslist1 = new ArrayList<Foods>();
		List<Foods> foodslist2 = new ArrayList<Foods>();
		
		foodslist1.add(foods1);
		foodslist1.add(foods2);
		foodslist1.add(foods3);
		foodslist2.add(foods4);
		foodslist2.add(foods5);
		foodslist2.add(foods6);
		
		restor1.setFoods(foodslist1);
		restor2.setFoods(foodslist2);
		
		
		Yaml yaml1 = new Yaml();
		
		List<Restor> finallist = new LinkedList<Restor>();
		finallist.add(restor1);
		finallist.add(restor2);
		
	    DumperOptions options = new DumperOptions();
	    options.setExplicitStart(true);
	    Yaml yaml = new Yaml(options);
	    System.out.println(yaml.dumpAll(finallist.iterator()));
	}
	
	/*public static void main(String[] args) {
		
		Writer w = new Writer();
		w.maker();
	}
	*/
	

}
