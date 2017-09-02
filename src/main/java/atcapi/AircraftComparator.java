package atcapi;

import atcapi.model.Aircraft;

import java.util.Comparator;

class AircraftComparator implements Comparator<Aircraft> {

    @Override
    public int compare(Aircraft ac1, Aircraft ac2){

        //if both aircraft same type
        if(ac1.getType().equals(ac2.getType())){
            return (ac1.getSize().compareTo(ac2.getSize()));
        }

        //otherwise
        return ac1.getType().compareTo(ac2.getType());

    }
}