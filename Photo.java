package DSproject;



public class Photo {
private String Path;
LinkedList<String> Tags = new LinkedList<>(String); 
	
// Constructor	
public Photo(String path, LinkedList<String> tags) {
Path = path;
if(!tags.empty()){
tags.findFirst();
while(!tags.last()){
Tags.insert(tags.retrieve()); //except the last node
tags.findNext();
} //while
Tags.insert(tags.retrieve()); // for the last node
} //if
} //method
	
// Return the full file name (the path) of the photo. A photo is uniquely identified by its path.
public String getPath() {
return path;
}
	
// Return all tags associated with the photo
public LinkedList<String> getTags(){
LinkedList<String> associatedTags = new LinkedList<String>();
	
if(Tags.empty()){
Tags.findFirst();
while(!Tags.last()){
associatedTags.insert(Tags.retrieve()); //except the last node
Tags.findNext();
} //while
associatedTags.insert(Tags.retrieve()); // for the last node
} //if
return associatedTags;
} //method


	
}//end of class


