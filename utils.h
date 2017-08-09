#include <math.h>
#include <cmath> 
#include <vector>
#define earthRadiusKm 6371.0

// Converts decimal degrees to radians
float deg2rad(float deg) {
	return (deg * M_PI / 180);
}

float km2mi(float km){
	return km/1.609344;
}

// Haversine formula for distance on a globe 
float distance(float lat1d, float lon1d, float lat2d, float lon2d) {
	float lat1r, lon1r, lat2r, lon2r, u, v;
	lat1r = deg2rad(lat1d);
	lon1r = deg2rad(lon1d);
	lat2r = deg2rad(lat2d);
	lon2r = deg2rad(lon2d);
	u = sin((lat2r - lat1r)/2);
	v = sin((lon2r - lon1r)/2);
	return km2mi(2.0 * earthRadiusKm * asin(sqrt(u * u + cos(lat1r) * cos(lat2r) * v * v)));
}

// Converts radians to decimal degrees
float rad2deg(float rad) {
	return (rad * 180 / M_PI);
}

std::vector<char> chars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

// Generates a char vector of a specified length filled with random 
std::vector<char> nrandchars(int amount){
	std::vector<char> final;
	std::vectormchars = chars;
	for(int i = 0;i<amount;i++){
		int randi = std::randint(0,25);
		final[i] = chars[randi];
		mchars.erase(std::remove(final.begin(), final.end(), randi), final.end());
	}
	return final;
}
