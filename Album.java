
package Dsproject;

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
