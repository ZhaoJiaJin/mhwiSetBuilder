package org.jiajinzhao.mhwi;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class BasicModule extends AbstractModule{
  @Override
  protected void configure() {
    bind(String.class).annotatedWith(Names.named("armor base")).toInstance("armors/armor_base.csv");
    bind(String.class).annotatedWith(Names.named("armor trans")).toInstance("armors/armor_base_translations.csv");
    bind(String.class).annotatedWith(Names.named("armor skills")).toInstance("armors/armor_skills_ext.csv");


  }
}
