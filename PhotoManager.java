package DSproject;


public class PhotoManager {
   LinkedList<Photo> photos; 
// Constructor
public PhotoManager() {
   photos = new LinkedList<Photo>; 
}
// Return all managed photos
public LinkedList<Photo> getPhotos(){
  return photos;
}
// Add a photo
public void addPhoto(Photo p) {
            if (!photos.empty()) {
	            boolean exists = false;
	            photos.findFirst();
	            while (!exists && !photos.last()) {
	                if (photos.retrieve().getPath().compareToIgnoreCase(p.getPath()) == 0) {
	                    exists = true;
	                }
	                photos.findNext();
	            }
	            if (!exists && photos.retrieve().getPath().compareToIgnoreCase(p.getPath()) == 0) {
	                exists = true;
	            }
	            if (!exists) {
	                photos.insert(p);
	            }
	        } else {
	           System.out.print("photo can't be added");
	        }
	
}
// Delete a photo
public void deletePhoto(String path) {
              if (!photos.empty()) {
	            boolean found = false;
	            photos.findFirst();
	            while (!found && !photos.last()) {
	                if (photos.retrieve().getPath().compareToIgnoreCase(path) == 0) {
	                    found = true;
	                    photos.remove();
	                } else {
	                    photos.findNext();
	                }
	            }
	            if (!found && photos.retrieve().getPath().compareToIgnoreCase(path) == 0) {
	                photos.remove();
	            }
	        }
	        else {
		           System.out.print("photo can't be deleted");
		        }
	        	
	
}
}
