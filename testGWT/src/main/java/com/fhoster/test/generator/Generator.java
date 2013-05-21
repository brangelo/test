package com.fhoster.test.generator;
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class Generator {

	private final String templatePath = "./src/main/java/com/fhoster/test/generator/template/";

	private final String clientPath = "./src/main/java/com/fhoster/test/client/";
	private final String presenterPath = clientPath+"presenter/";
	private final String viewPath = clientPath+"view/";
	private final String ginFile = clientPath+"gin/ClientModule.java";
	private final String placeFile = clientPath+"place/NameTokens.java";
	private final String menuFile = viewPath+"MenuView.java";

	public Generator() {
		Velocity.init();
	}

	/**
	 * @param presentersNumber total number of pages
	 * @param ltsNumber LiveTable per Views
	 * @param useLt use LiveTable as DataGrid
	 * @throws IOException
	 */
	public void generate(int presentersNumber, int ltsNumber, boolean useLt) throws IOException{

		String viewTemplate = "view.vm";
		if(!useLt) viewTemplate = "view2.vm";
		
		VelocityContext context = new VelocityContext();
		List<Integer> numbers = getNumbers(presentersNumber);
		List<Integer> ltNumbers = getNumbers(ltsNumber);
		context.put("ltNumbers", ltNumbers);
		
		for (Integer n : numbers) {
			context.put("number", n);
			_generate("presenter.vm", presenterPath+"LtPresenter"+n+".java", context);
			_generate(viewTemplate, viewPath+"LtView"+n+".java", context);
		}
		
		context.put("numbers", numbers);
		_generate("gin.vm", ginFile, context);
		_generate("places.vm", placeFile, context);
		_generate("menu.vm", menuFile, context);
	}

	private void _generate(String templateFile, String outputFile, VelocityContext context) throws IOException{
		
		Template template =  null;
		String inputFile = templatePath+templateFile;
		template = Velocity.getTemplate(inputFile);

		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(outputFile)));

		if ( template != null)
			template.merge(context, writer);

		writer.flush();
		writer.close();
	}

	private List<Integer> getNumbers(int maxNumber) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= maxNumber; i++) 
			list.add(i);
		return list;
	}

}
