package DSproject;

public class TestPhotoManager {
public static void main(String[] args) {
PhotoManager manager = new PhotoManager();
  
Photo photo1 = new Photo("hedgehog.jpg",toTagsLinkedList("animal, hedgehog, apple, grass, green"));
manager.addPhoto(photo1);
  
Photo photo2 = new Photo("bear.jpg",toTagsLinkedList("animal, bear, cab, grass, wind"));
manager.addPhoto(photo2);
  
Photo photo3 = new Photo("orange-butterfly.jpg",toTagsLinkedList("insect, butterfly, flower, color"));
manager.addPhoto(photo3);
  
Album album1 = new Album("Album1", "bear", manager);
Album album2 = new Album("Album2", "animal AND grass", manager);
  
System.out.println("Get photo1 path and tags:");
System.out.println("photo1 path: " + photo1.getPath());
  
//You can get the list of tags of photo1 by calling photo1.getTags().
LinkedList<String> Tags = photo1.getTags();
//You can write a method that prints the list of tags of photo1.
printTags(Tags);


System.out.println("\nGet album2 name, condition, and photos:");
System.out.println("album2 name: " + album2.getName());
System.out.println("album2 condition: " + album2.getCondition());

//You can get the list of photos in album2 by calling album2.getPhotos().
LinkedList<Photo> Photos = album2.getPhotos();
//You can write a method that prints the list of photos in album2.
printPhotos(Photos);
  
System.out.println("\nDelete the photo ’bear.jpg’:\n");
manager.deletePhoto("bear.jpg");

System.out.println("Get album2 name, condition, and photos:");
System.out.println("album2 name: " + album2.getName());
System.out.println("album2 condition: " + album2.getCondition());
printPhotos(album2.getPhotos());


}

private static LinkedList<String> toTagsLinkedList(String tags) {
LinkedList<String> result = new LinkedList<String>();
String[] tagsArray = tags.split("\\s*,\\s*");
for (int i = 0; i < tagsArray.length; i++) {
result.insert(tagsArray[i]);
}
return result;
}
  
public static void printTags(LinkedList<String> TagsList){
	   TagsList.findfirst();
            if(TagsList.empty()) 
                return;
            
            while(!TagsList.last())
            {
                System.out.print(TagsList.retrieve() + " ");
                TagsList.findnext();
            }
            System.out.print(TagsList.retrieve() + " ");
            System.out.println(" ");
           
}

public static void printPhotos(LinkedList<Photo> photosList){
	   photosList.findfirst();
            if(photosList.empty()) 
                return;
            
            while(!photosList.last())
            {
                System.out.println(photosList.retrieve().getPath());
                photosList.findnext();
            }
            System.out.println(photosList.retrieve().getPath());
        }
  
}
