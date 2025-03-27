
package DSproject;



public class Photo {
private String Path;
LinkedList<String> Tags = new LinkedList<>(); 
	
// Constructor	
public Photo(String path, LinkedList<String> tags) {
Path = path;

if(!tags.empty()){
tags.findfirst();
while(!tags.last()){
Tags.insert(tags.retrieve()); //except the last node
tags.findnext();
} //while
Tags.insert(tags.retrieve()); // for the last node
} //if
} //method
	
// Return the full file name (the path) of the photo. A photo is uniquely identified by its path.
public String getPath() {
return Path;
}
	
// Return all tags associated with the photo
public LinkedList<String> getTags(){
LinkedList<String> associatedTags = new LinkedList<String>();
	
if(!Tags.empty()){
Tags.findfirst();
while(!Tags.last()){
associatedTags.insert(Tags.retrieve()); //except the last node
Tags.findnext();
} //while
associatedTags.insert(Tags.retrieve()); // for the last node
} //if
return associatedTags;
} //method


	
}//end of class


