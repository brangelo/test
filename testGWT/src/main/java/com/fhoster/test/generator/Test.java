package com.fhoster.test.generator;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Test {
 private static Generator generator = new Generator();

 public static void main(final String[] args) {
  try {
   generate(500, 1, true);
   generate(500, 10, true);
   generate(500, 100, true);
   generate(500, 1000, true);

   generate(500, 1, false);
   generate(500, 10, false);
   generate(500, 100, false);
   generate(500, 1000, false);

   System.out.println("Done");
  } catch (IOException e) {
   e.printStackTrace();
  }
 }

 private static void generate(final int numOfPresenter, final int gridPerView, final boolean useLT) throws IOException, ClientProtocolException {
  long start = System.currentTimeMillis();
  generator.generate(numOfPresenter, gridPerView, useLT);
  DefaultHttpClient client = new DefaultHttpClient();
  client.execute(new HttpGet("http://localhost:9876/recompile/project?user.agent=safari&_callback=asdasdasd"));
  long end = System.currentTimeMillis();
  System.out.println(String.format("time = %s ms: numOfPresenter = %s,  gridPerView = %s useLT = %s", end - start, numOfPresenter, gridPerView, useLT));
 }
}