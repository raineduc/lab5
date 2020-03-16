package lab5.database;

import javax.xml.bind.*;
import javax.xml.bind.helpers.DefaultValidationEventHandler;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import lab5.lib.ValidationException;

public class XmlManager<T> implements Manager<T> {
  private File file;
  private Class<T> classObject;

  public XmlManager(File file, Class<T> classObject) {
    this.file = file;
    this.classObject = classObject;
  }

  public T read() throws ValidationException, SourceEmptyException {
    try {
      if (file.length() == 0) {
        throw new SourceEmptyException("File is empty");
      }
      JAXBContext context = JAXBContext.newInstance(classObject);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      Object o = unmarshaller.unmarshal(file);

      unmarshaller.setEventHandler(new DefaultValidationEventHandler());


      T casted = classObject.cast(o);
      if (casted == null) {
        throw new ValidationException("Apparently, your xml file is invalid");
      }

      return casted;
    } catch (JAXBException e) {
      throw new ValidationException("Something has gone wrong with xml unmarshalling (Probably xml file is invalid): \n" +
              e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
    }
  }

  public void save(T object) throws ValidationException {
    try {
      JAXBContext context = JAXBContext.newInstance(classObject);
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.marshal(object, new PrintWriter(new FileWriter(file)));
    } catch (JAXBException e) {
      throw new ValidationException("Something has gone wrong with xml marshalling: (Probably class has" +
              " invalid annotations)\n" +
              e.getMessage());
    } catch (IOException e) {
      throw new ValidationException("Provided file is not available: \n" + e.getMessage());
    }
  }
}
