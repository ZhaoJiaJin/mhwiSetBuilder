package org.jiajinzhao.mhwi;

import java.io.IOException;
import org.jiajinzhao.mhwi.data.ArmorManager;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class ArmorFinder {
  public static void main(String[] args) throws IOException {
    Injector injector = Guice.createInjector(new BasicModule());
    ArmorManager manager = injector.getInstance(ArmorManager.class);
    //loadArmors();

  }
}
