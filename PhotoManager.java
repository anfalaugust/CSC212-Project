package DSproject;


public class PhotoManager {
   LinkedList<Photo> Photos; 
// Constructor
public PhotoManager() {
   Photos = new LinkedList<Photo>(); 
}
// Return all managed photos
public LinkedList<Photo> getPhotos(){
  return Photos;
}
// Add a photo
public void addPhoto(Photo p){
if (Photos.empty()) {
Photos.insert(p);
return;
}

Photos.findfirst();
 while (!Photos.last())
 {
    if (Photos.retrieve().getPath().equals(p.getPath()))
        return;

    Photos.findnext();
 }

 if (Photos.retrieve().getPath().equals(p.getPath()))
	 return;
 
 Photos.insert(p);
 

	 
 
}

// Delete a photo
public void deletePhoto(String path) {
if (!Photos.empty()) {
  Photos.findfirst();
    while (!Photos.last()) {
       if (Photos.retrieve().getPath().equals(path)) 
          Photos.remove();
          return;
} 
Photos.findnext();
}
	            
if (Photos.retrieve().getPath().equals(path))
	 return; 

Photos.remove();
	      
	        
	        	
	
}
}
