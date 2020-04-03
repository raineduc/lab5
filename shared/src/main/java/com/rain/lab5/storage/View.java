package com.rain.lab5.storage;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlRootElement(name = "view")
@XmlType(name = "view")
public enum View {
  @XmlEnumValue("yard")
  YARD,
  @XmlEnumValue("park")
  PARK,
  @XmlEnumValue("good")
  GOOD,
  @XmlEnumValue("terrible")
  TERRIBLE;
}
