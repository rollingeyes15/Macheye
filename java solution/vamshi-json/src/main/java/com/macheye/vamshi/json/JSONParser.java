package com.macheye.vamshi.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class JSONParser {

	public static void main(String[] args) throws IOException, ScriptException {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");

		String json = new String(Files.readAllBytes(Paths.get("./src/main/resources/data1.json")));
		String script = "Java.asJSONCompatible(" + json + ")";
		Object result = engine.eval(script);
		//        List<Map <String, String>> jsonArray = (List <Map <String, String>>) result;
		/*Map<String, String> contents = (Map) result;
        contents.forEach((t, u) -> {

	           System.out.println(t.getClass().getCanonicalName());
	           System.out.println(u.getClass().getCanonicalName()); 

        });*/

	}
}