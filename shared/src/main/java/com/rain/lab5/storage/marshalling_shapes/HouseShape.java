package com.rain.lab5.storage.marshalling_shapes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "house")
@XmlAccessorType(XmlAccessType.FIELD)
public class HouseShape {
  public String name; //Поле может быть null
  public Integer year; //Поле не может быть null, Значение поля должно быть больше 0
}
