<%-- 
    Document   : property_register
    Created on : 22 Apr, 2023, 3:51:37 PM
    Author     : Vaibhav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <style>
       
        @media (min-width: 1025px) {
            .h-custom {
                height: 100vh !important;
            }
        }
        select{
            display:block;
            height:30px;
            border-radius: 5px;
        }

    </style>
</head>
<body>
    <section class="h-100 h-custom" style="background-color: #8fc4b7;">
        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-8 col-xl-6">
              <div class="card rounded-3">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
                  class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
                  alt="Sample photo">
                <div class="card-body p-4 p-md-5">
                  <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Property Registration Form</h3>
      
                  
                  <form action="propertyServlet" method="post" class="px-md-2" enctype="multipart/form-data">
                    <div class="row">
                      <div class="col-md-6 mb-4">
                        <div class="form-outline">
                          <label for="location" class="form-label">Location</label>
                          <input type="text" class="form-control" name="location" id="location" />
                        </div>
                      </div>
                      <div class="col-md-6 mb-4">
                        <div class="form-outline">
                            <label for="location" class="form-label">Property-Type</label>
                            <input type="text" class="form-control" name="property_type" id="property-type" />                           
                          </div>
                      </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label for="status" class="form-label">Status</label>
                            <select class="form-control" name="status">
                              <option disabled selected>--------------------</option>
                              <option value="2">For Rent</option>
                              <option value="3">For Sale</option>
                            </select>
                        </div>
                        <div class="col-md-6 mb-4">
                          <div class="form-outline">
                              <label for="area" class="form-label">Area(sq. meter)</label>
                              <input type="text" class="form-control" id="area" name="area" />
                            </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="col-md-4 mb-4">
                          <div class="form-outline">
                            <label for="beds" class="form-label">Beds</label>
                            <input type="number" class="form-control" name="beds" id="beds" min=0>
                          </div>
                        </div>
                        <div class="col-md-4 mb-4">
                            <div class="form-outline">
                              <label for="balcony" class="form-label">Balcony</label>
                              <input type="number" class="form-control" name="balcony" id="balcony" min=0>
                            </div>
                          </div>
                        <div class="col-md-4 mb-4">
                            <div class="form-outline">
                                <label for="baths" class="form-label">Bath</label>
                                <input type="number" class="form-control" id="baths" name="baths" min=0 />
                            </div>
                        </div>
                      </div>
                      <div class="row">
                        <div class="form-outline">
                            <div class="col-md-6">
                                <label for="description" class="form-label">Description(50-70 words)</label>
                            </div>
                            <textarea class="form-control mb-3" id="description" name="description" rows="5" cols="60" placeholder="Type your text"></textarea>
                        </div>
                      </div>
                    <div class="row">
                        <div class="form-outline">
                            <div class="col-md-6">
                                <label for="price" class="form-label">Price</label>
                                <input type="text" class="form-control" name="price" id="price">
                            </div>
                        </div>
                    </div>
                    <br>

                    <label>Amenities</label>
                    <br>
                    <div class="row">
                        <div class="col-md-4 col-lg-3">
                            <input type="checkbox" id="swimming_pool-Pool" name="swimming_pool">
                            <label for="Swimming-Pool">Pool</label>
                        </div>
                        <div class="col-md-4 col-lg-3">
                            <input type="checkbox" id="gym" name="gym">
                            <label for="Gym">Gym</label>

                        </div>
                        <div class="col-md-4 col-lg-3">
                            <input type="checkbox" id="garden" name="garden">
                            <label for="Garden">Garden</label>
                        </div>
                        <div class="col-md-4 col-lg-3">
                            <input type="checkbox" id="club_house" name="club_house">
                            <label for="Club-House">Club-House</label>
                        </div>
                        <div class="col-md-4 col-lg-3">
                            <input type="checkbox" id="internet" name="internet">
                            <label for="Internet">Internet</label>
                        </div>
                        <div class="col-md-4 col-lg-3">
                            <input type="checkbox" id="badminton" name="badminton">
                            <label for="badminton">Badminton</label>
                        </div>
                    </div>
                    <br>
                    <div class="row mb-2">
                        <div class="col-lg-6">
                            <label for="file">Property Image 1:</label>
                        </div>
                        <div class="col-lg-6">
                            <input type="file" id="image1" name="image1" class="form-control">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-lg-6">
                            <label for="file">Property Image 2:</label>
                        </div>
                        <div class="col-lg-6">
                            <input type="file" id="image2" name="image2" class="form-control">
                        </div>
                    </div>
                    <div class="row mb-2">
                        <div class="col-lg-6">
                            <label for="file">Property Image 3:</label>
                        </div>
                        <div class="col-lg-6">
                            <input type="file" id="image3" name="image3" class="form-control">
                        </div>
                    </div>
                  <br>
                    <button type="submit" class="btn btn-success btn-lg mb-1">Submit</button>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
        
</body>
</html>