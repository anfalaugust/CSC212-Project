public class Album {
// Constructor
public Album(String name, String condition, PhotoManager manager) {
	
}
// Return the name of the album
public String getName() {
	
}
// Return the condition associated with the album
public String getCondition() {
	
}
// Return the manager
public PhotoManager getManager() {
	
}
// Return all photos that satisfy the album condition
public LinkedList<Photo> getPhotos(){
	
}
// Return the number of tag comparisons used to find all photos of the album
public int getNbComps() {
	
}
	
        // Return all photos that satisfy the album condition
        public LinkedList<Photo> getPhotos()
        {
                LinkedList<Photo> Rphotos = new LinkedList<Photo>();
                {
                    LinkedList<Photo> photos1 = manager.getPhotos();
                    if (! photos1.empty())
                    {
                        photos1.findFirst();
                        while (! photos1.last())
                        {
                            Rphotos.insert(new Photo(photos1.retrieve().getPath(), photos1.retrieve().getTags()));
                            photos1.findNext();
                        }
                        Rphotos.insert(new Photo(photos1.retrieve().getPath(), photos1.retrieve().getTags()));
                    }
                }
                NbComps =0 ;
                
                if (this.condition.compareTo("") != 0)
                {
                    String [] Array = condition.split(" AND ");
                    
                    Rphotos.findFirst();
                    while ( ! Rphotos.last())
                    {
                        Photo photo = Rphotos.retrieve();
                        //System.out.println("test " + photo.getPath());
                        if ( ! allAvilable (photo.allTags , Array ))
                            Rphotos.remove();
                        else
                            Rphotos.findNext();
                    }
                    Photo photo11 = Rphotos.retrieve();
                    //System.out.println("testlast " + photo11.getPath());
                    if ( ! allAvilable (photo11.allTags , Array ))
                        Rphotos.remove();
                    else
                        Rphotos.findNext();
                }
                return Rphotos;
        }
       
        // Return the number of tag comparisons used to find all photos of the album
        public int getNbComps()
        {
            return NbComps;
        }

        private boolean allAvilable ( LinkedList<String> AllTags , String [] Array )
        {
            boolean continue1 = true;
            if (AllTags.empty())
                continue1 = false;
            else
            {
                for ( int i = 0 ; i < Array.length && continue1 ; i++)
                {
                    boolean found_in_tags = false;

                    AllTags.findFirst();

                    while (!AllTags.last())
                    {
                        this.NbComps ++ ;    
                        //System.out.println(AllTags.retrieve() + " " + Array[i]);
                        if (AllTags.retrieve().compareToIgnoreCase(Array[i]) == 0)
                        {
                            found_in_tags = true;
                            break;
                        }
                        AllTags.findNext();
                    }
                    if (! found_in_tags )
                    {
                        this.NbComps ++ ;
                        //System.out.println(AllTags.retrieve() + " " + Array[i]);
                        if (AllTags.retrieve().compareToIgnoreCase(Array[i]) == 0)
                            found_in_tags = true;
                    }
                    if ( ! found_in_tags )
                        continue1 = false;
                }
            }
            return continue1;
        }
       
}
}
