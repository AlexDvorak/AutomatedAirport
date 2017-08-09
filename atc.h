/* format for tower requests in json:
 Operations:
-- pushbackapprove
-- taxirequest
-- takeoff
{
  "plane": "N09456",
  "request":{
    "operation": "pushbackleft"
  }
}
{
  "plane": "N09456",
  "request":{
    "operation": "taxirequest",
    "route":["F","D","hs21L"]
  }
}
{
  "plane": "N09456",
  "request":{
    "operation": "takeoff",
    "runway":"12L"
  }
}
// format for tower responses
{
  "plane": "N09456"
  "response":{
    "operation":"pushback",
    "verdict":true
  }
}
{
  "plane":"N09456",
  "response":{
    "operation":"takeoff",
    "runway":"21L",
    "verdict":"approved"
  }
}
{
  "plane": "N09456",
  "response":{
    "operation": "taxirequest",
    "route":["F","D","hs21L"],
    "verdict":true
  }
}
*/
#include "utils.h"
#include <vectors>

class GND{
  private:
    std::vector<string> queue;
    std::vector<string> responses;
  public:
    void sendRequest(string req){
      queue.push_back(req);
    };
};
