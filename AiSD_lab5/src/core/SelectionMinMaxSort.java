package core;

import java.util.*;

public class SelectionMinMaxSort<T> extends SortingAlgorithm<T>{

    public SelectionMinMaxSort(Comparator comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        T Tmin, Tmax;

        for(int i = 0; i < list.size()/2; i++){
            Tmin = list.get(i);
            Tmax = Tmin;

            for(int j = i+1; j < list.size()-i; j++){
                if(this.compare(Tmin,list.get(j)) > 0){
                    Tmin = list.get(j);
                }
                if(this.compare(Tmax,list.get(j)) <= 0){
                    Tmax = list.get(j);
                }
            }
            swap(list, list.indexOf(Tmin),i);

            swap(list,list.size()-1-i,list.indexOf(Tmax));
        }

        return list;
    }
}
