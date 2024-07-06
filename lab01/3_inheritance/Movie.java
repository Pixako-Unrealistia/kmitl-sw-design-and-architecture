public static Movie newNewRelease(String name){
	Movie result = new Movie (name);
	result.beNewRelease();
	return result;
}
public static Movie newRegular(String name){
	Movie result = new Movie (name);
	result.beRegular();
	return result;
}
public static Movie newChildrens(String name) {
	Movie result = new Movie (name);
	result.beChildrens();
	return result;
}

private Movie(String name) {
	_name = name;
}  