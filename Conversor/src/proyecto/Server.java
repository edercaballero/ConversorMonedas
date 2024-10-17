package proyecto;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Server{
   private  HttpClient client;
   private HttpRequest request;
   private HttpResponse<String> response;

    public Server(String url_link){
        client= HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
            .uri(URI.create(url_link))
            .build();
        try{  
            response = client
            .send(request, BodyHandlers.ofString());
        } catch (InterruptedException | IOException e){
            System.out.println("There was a problem. \n");
        }

    }

    public HttpResponse<String> getInfo(){
        return response;
    }
}
