/*package Dsproject;
public class Album {
        private String name;
        private String condition;
        private PhotoManager manager;
        private int NbComps;

        // Constructor
        public Album(String name, String condition, PhotoManager manager)
        {
            this.name = name;
            this.condition = condition;
            this.manager = manager;
            NbComps =0 ;
        }

        // Return the name of the album
        public String getName()
        {
            return name;
        }
        
        // Return the condition associated with the album
        public String getCondition()
        {
            return condition;
        }

        // Return the manager
        public PhotoManager getManager()
        {
            return manager;
        }
        
        // Return all photos that satisfy the album condition
        public LinkedList<Photo> getPhotos()
        {
                LinkedList<Photo> Rphotos = new LinkedList<Photo>();
                {
                    LinkedList<Photo> photos1 = manager.getPhotos();
                    if (! photos1.empty())
                    {
                        photos1.findfirst();
                        while (! photos1.last())
                        {
                            Rphotos.insert(new Photo(photos1.retrieve().getPath(), photos1.retrieve().getTags()));
                            photos1.findnext();
                        }
                        Rphotos.insert(new Photo(photos1.retrieve().getPath(), photos1.retrieve().getTags()));
                    }
                }
                NbComps =0 ;
                
                if (this.condition.compareTo("") != 0)
                {
                    String [] Array = condition.split(" AND ");
                    
                    Rphotos.findfirst();
                    while ( !( Rphotos.last()))
                    {
                        Photo photo = Rphotos.retrieve();
                        //System.out.println("test " + photo.getPath());
                        if ( !allAvilable (photo.Tags , Array ))
                            Rphotos.remove();
                        else
                            Rphotos.findnext();
                    }
                    Photo photo11 = Rphotos.retrieve();
                    //System.out.println("testlast " + photo11.getPath());
                    if ( !allAvilable (photo11.Tags , Array ))
                        Rphotos.remove();
                    else
                        Rphotos.findnext();
                }
                return Rphotos;
        }
       
        // Return the number of tag comparisons used to find all photos of the album
        public int getNbComps()
        {
            return NbComps;
        }

        private boolean allAvilable ( LinkedList<String> Tags , String [] Array )
        {
            boolean continue1 = true;
            if (Tags.empty())
                continue1 = false;
            else
            {
                for ( int i = 0 ; i < Array.length && continue1 ; i++)
                {
                    boolean found_in_tags = false;

                    Tags.findfirst();

                    while (!Tags.last())
                    {
                        this.NbComps ++ ;    
                        //System.out.println(AllTags.retrieve() + " " + Array[i]);
                        if (Tags.retrieve().compareToIgnoreCase(Array[i]) == 0)
                        {
                            found_in_tags = true;
                            break;
                        }
                        Tags.findnext();
                    }
                    if (! found_in_tags )
                    {
                        this.NbComps ++ ;
                        //System.out.println(AllTags.retrieve() + " " + Array[i]);
                        if (Tags.retrieve().compareToIgnoreCase(Array[i]) == 0)
                            found_in_tags = true;
                    }
                    if ( ! found_in_tags )
                        continue1 = false;
                }
            }
            return continue1;
        }
       
}*/
package Dsproject;

//import java.util.LinkedList;

public class Album {
    private String name;
    private String condition;
    private PhotoManager manager;
    private int comparisonCount;

    // Constructor
    public Album(String name, String condition, PhotoManager manager) {
        this.name = name;
        this.condition = condition;
        this.manager = manager;
        this.comparisonCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getCondition() {
        return condition;
    }

    public PhotoManager getManager() {
        return manager;
    }

    public int getNbComps() {
        return comparisonCount;
    }

    public LinkedList<Photo> getPhotos() {
        LinkedList<Photo> resultPhotos = new LinkedList<>();
        LinkedList<Photo> allPhotos = manager.getPhotos();

        // Clone the list
        if (!allPhotos.empty()) {
            allPhotos.findfirst();
            while (!allPhotos.last()) {
                resultPhotos.insert(new Photo(allPhotos.retrieve().getPath(), allPhotos.retrieve().getTags()));
                allPhotos.findnext();
            }
            resultPhotos.insert(new Photo(allPhotos.retrieve().getPath(), allPhotos.retrieve().getTags()));
        }

        comparisonCount = 0;

        // Filter by condition
        if (condition.equals("") != false) {
            String[] requiredTags = condition.split(" AND ");
            resultPhotos.findfirst();
            while (!resultPhotos.last()) {
                if (!containsAllTags(resultPhotos.retrieve().getTags(), requiredTags)) {
                    resultPhotos.remove();
                } else {
                    resultPhotos.findnext();
                }
            }

            // Check last item
            if (!containsAllTags(resultPhotos.retrieve().getTags(), requiredTags)) {
                resultPhotos.remove();
            }
        }

        return resultPhotos;
    }

    private boolean containsAllTags(LinkedList<String> tags, String[] required) {
        
        
        for (String tag : required) {
            boolean found = false;
            tags.findfirst();
            while (!tags.last()) {
                comparisonCount++;
                if (tags.retrieve().equalsIgnoreCase(tag)) {
                    found = true;
                    break;
                }
                tags.findnext();
            }

            if (!found) {
                comparisonCount++;
                if (!tags.retrieve().equalsIgnoreCase(tag)) {
                    return false;
                }
            }
        }

        return true;
    }
}
