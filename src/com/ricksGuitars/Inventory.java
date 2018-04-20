package com.ricksGuitars;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
private List<Guitar> guitars;

  public Inventory() {
    guitars = new LinkedList<Guitar>();
  }

  public void addGuitar(String serialNumber, double price,
                        Builder builder, String model,
                        Type type, Wood backWood, Wood topWood) {
    GuitarSpec guitarSpec = new GuitarSpec(builder, model, type, 
            backWood, topWood);
    Guitar guitar = new Guitar(serialNumber, price, guitarSpec);
    guitars.add(guitar);
  }
  
  public Guitar getGuitar(String serialNumber) {
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }
  
  public List<Guitar> search(GuitarSpec searchGuitarSpec) {
      List<Guitar> matchingGuitars = new LinkedList<Guitar>();
    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = i.next();
      GuitarSpec guitarSpec = guitar.getGuitarSpec();
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      String builder = searchGuitarSpec.getBuilder();
      if ((builder != null) && (!builder.equals("")) &&
          (!builder.equals(guitarSpec.getBuilder())))
        continue;
      String model = searchGuitarSpec.getModel().toLowerCase();
      if ((model != null) && (!model.equals("")) &&
          (!model.equals(guitarSpec.getModel().toLowerCase())))
        continue;
      String type = searchGuitarSpec.getType();
      if ((type != null) && (!searchGuitarSpec.equals("")) &&
          (!type.equals(guitarSpec.getType())))
        continue;
      String backWood = searchGuitarSpec.getBackWood();
      if ((backWood != null) && (!backWood.equals("")) &&
          (!backWood.equals(guitarSpec.getBackWood())))
        continue;
      String topWood = searchGuitarSpec.getTopWood();
      if ((topWood != null) && (!topWood.equals("")) &&
          (!topWood.equals(guitarSpec.getTopWood())))
        continue;
      matchingGuitars.add(guitar);
    }
    return matchingGuitars;
  }
}
