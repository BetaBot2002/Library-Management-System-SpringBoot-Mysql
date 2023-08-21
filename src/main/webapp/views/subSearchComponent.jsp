<%@page import="java.util.Map"%>
<style>
    p {
        font-family: Arial, Helvetica, sans-serif !important;
    }

    .search_items {
        box-sizing: border-box;
        color: aliceblue;
    }
    
    .search_items > input {
        width: 100%;
        margin-bottom: 10px;
    }

    .search_items > button {
        width: 100%;
    }

    .filter-buttons > div {
        width: 100%;
        display: flex;
        gap: 10px;
    }

    .filter-buttons > div > button {
        width: 100%;
        margin-bottom: 3px;
        border-radius: 20px !important;
        box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
    }
</style>
<body>
    <% 
        String searchValue=((String) request.getAttribute("searchValue"))==null?"":(String) request.getAttribute("searchValue");
        String type=(String) request.getAttribute("type");
        Map<String,String> filters=(Map<String,String>)request.getAttribute("filtersearches");
    %>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <section class="headerview">
        
        <p  style="font-size: 20px; font-weight: lighter; margin-bottom: 5px;"><i class="fa-solid fa-circle" style="color: #ffffff;"></i> Choose Type</p>
        <div>
            <div class="filter-buttons">
                <div>
                    <button type="submit" name="itemtype" formaction="/search/filter" form="search" value="books">Books</button>
                    <button type="submit" name="itemtype" formaction="/search/filter" form="search" value="journals">Journals</button>
                </div>
                <div>
                    <button type="submit" name="itemtype" formaction="/search/filter" form="search" value="magazines">Magazines</button>
                    <button type="submit" name="itemtype" formaction="/search/filter" form="search" value="theses">Theses</button>
                </div>
                <div>
                    <button type="submit" name="itemtype" formaction="/search/filter" form="search" value="softcopy">SoftCopy</button>
                </div>
            </div>
            <br>
            <div class="filter">
                <p style="font-size: 20px; font-weight: lighter; margin-bottom: 5px;"><i class="fa-solid fa-circle-notch" style="color: #ffffff;"></i>  Filters</p>
                <div class="filter-buttons">
                    <div>
                        <button type="submit" formaction="/search/author" form="search">Author</button>
                        <button type="submit" formaction="/search/researcher" form="search">Researcher</button>
                    </div>
                    <div>
                        <button type="submit" formaction="/search/editor" form="search">Editor</button>
                        <button type="submit" formaction="/search/owner" form="search">Owner</button>
                    </div>
                    <div>
                        <button type="submit" formaction="/search/publisher" form="search">Publisher</button>
                        <button type="submit" formaction="/search/category" form="search">Category</button>
                    </div>
                    <div>
                        <button type="submit" formaction="/search/title" form="search">Title</button>
                    </div>
                </div>
            </div>
            <%if(type!=null){%>
                <br>
                <div class="exclusivfilter">
                    <p style="font-size: 20px; font-weight: lighter; margin-bottom: 5px;"><i class="fa-sharp fa-solid fa-filter-circle-dollar" style="color: #ffffff;"></i> Exclusive filters on <span style="text-transform: capitalize;"><%= type %></span></p>
                    
                        <%if(type.equals("books")){%>
                            <form action="/search/filter" method="Get" id="book_filter">
                                <div class="search_items">
                                    <label>Title</label>
                                    <input id="title" name="title" class="filter" type="text" placeholder="Enter Title" value='<%=filters==null?"":filters.get("title")%>'>
                                
                                    <label>Author</label>
                                    <input id="author" name="author" class="filter" type="text" placeholder="Enter Author" value='<%=filters==null?"":filters.get("author")%>'>
                                    
                                    <label>Publisher</label>
                                    <input id="publisher" name="publisher" class="filter" type="text" placeholder="Enter Publisher" value='<%=filters==null?"":filters.get("publisher")%>'>
                    
                                    <label>Category</label>
                                    <input id="category" name="category" class="filter" type="text" placeholder="Enter Category" value='<%=filters==null?"":filters.get("category")%>'>
                    
                                    <label>Keywords</label>
                                    <input id="keywords" name="keywords" class="filter" type="text" placeholder="Enter Keywords" value='<%=filters==null?"":filters.get("keywords")%>'>
                    
                                    <label>Edition</label>
                                    <input id="edition" name="edition" class="filter" type="text" placeholder="Enter Edition" value='<%=filters==null?"":filters.get("edition")%>'>
                                    
                                    <input id="edition" name="itemtype" class="filter" type="text" value="<%=type%>" hidden>
            
                                    <button type="submit" form="book_filter">Apply Filter</button>
                                </div>
                            </form>
                        <%}else if(type.equals("journals")){%>
                            <form action="/search/filter" method="Get" id="journals_filter">
                                <div class="search_items">
                                    <label>Title</label>
                                    <input id="title" name="title" class="filter" type="text" placeholder="Enter Title" value='<%=filters==null?"":filters.get("title")%>'>
                                
                                    <label>Publisher</label>
                                    <input id="publisher" name="publisher" class="filter" type="text" placeholder="Enter Publisher" value='<%=filters==null?"":filters.get("publisher")%>'>
                    
                                    <label>Editor</label>
                                    <input id="editor" name="editor" class="filter" type="text" placeholder="Enter Editor" value='<%=filters==null?"":filters.get("editor")%>'>
                                    
                                    <label>Category</label>
                                    <input id="category" name="category" class="filter" type="text" placeholder="Enter Category" value='<%=filters==null?"":filters.get("category")%>'>
                                    
                                    <label>Keywords</label>
                                    <input id="keywords" name="keywords" class="filter" type="text" placeholder="Enter Keywords" value='<%=filters==null?"":filters.get("keywords")%>'>
                                    
                                    <label>Start Year</label>
                                    <input id="startyear" name="startyear" class="filter" type="text" placeholder="Enter Start Year" value='<%=filters==null?"":filters.get("startyear")%>'>
                    
                                    <label>End Year</label>
                                    <input id="endyear" name="endyear" class="filter" type="text" placeholder="Enter End Year" value='<%=filters==null?"":filters.get("endyear")%>'>
                                    <input id="edition" name="itemtype" class="filter" type="text" value="<%=type%>" hidden>
                                    <button type="submit" form="journals_filter">Apply Filter</button>
                                </div>
                            </form>
                        <%}else if(type.equals("magazines")){%>
                            <form action="/search/filter" method="Get" id="magazine_filter">
                                <div class="search_items">
                                    <label>Title</label>
                                    <input id="title" name="title" class="filter" type="text" placeholder="Enter Title" value='<%=filters==null?"":filters.get("title")%>'>
                                
                                    <label>Publisher</label>
                                    <input id="publisher" name="publisher" class="filter" type="text" placeholder="Enter Publisher" value='<%=filters==null?"":filters.get("publisher")%>'>
                    
                                    <label>Issue Date</label>
                                    <input id="issuedate" name="issuedate" class="filter" type="text" placeholder="Enter Issue Date" value='<%=filters==null?"":filters.get("issuedate")%>'>
                                    
                                    <label>Issue Number</label>
                                    <input id="issuenumber" name="issuenumber" class="filter" type="text" placeholder="Enter Issue Number" value='<%=filters==null?"":filters.get("issuenumber")%>'>
                                    
                                    <label>Frequency</label>
                                    <input id="frequency" name="frequency" class="filter" type="text" placeholder="Enter Frequency" value='<%=filters==null?"":filters.get("frequency")%>'>
                                    
                                    <label>Keywords</label>
                                    <input id="keywords" name="keywords" class="filter" type="text" placeholder="Enter Keywords" value='<%=filters==null?"":filters.get("keywords")%>'>
                    
                                    <label>Special Issue</label>
                                    <input id="specialissue" name="specialissue" class="filter" type="text" placeholder="Enter Special Issue" value='<%=filters==null?"":filters.get("specialissue")%>'>
                                    
                                    <label>Category</label>
                                    <input id="category" name="category" class="filter" type="text" placeholder="Enter Category" value='<%=filters==null?"":filters.get("category")%>'>
                                    <input id="edition" name="itemtype" class="filter" type="text" value="<%=type%>" hidden>
                                    
                                    <button type="submit" form="magazine_filter">Apply Filter</button>
                                </div>
                            </form>
                        <%}else if(type.equals("theses")){%>
                            <form action="/search/filter" method="Get" id="theses_filter">
                                <div class="search_items">
                                    <label>Title</label>
                                    <input id="title" name="title" class="filter" type="text" placeholder="Enter Title" value='<%=filters==null?"":filters.get("title")%>'>
                                
                                    <label>Researcher</label>
                                    <input id="researcher" name="researcher" class="filter" type="text" placeholder="Enter Researcher" value='<%=filters==null?"":filters.get("researcher")%>'>
                    
                                    <label>Guides</label>
                                    <input id="guides" name="guides" class="filter" type="text" placeholder="Enter Guides" value='<%=filters==null?"":filters.get("guides")%>'>
                                    
                                    <label>Category</label>
                                    <input id="category" name="category" class="filter" type="text" placeholder="Enter Category" value='<%=filters==null?"":filters.get("category")%>'>
                                    
                                    <label>Keywords</label>
                                    <input id="keywords" name="keywords" class="filter" type="text" placeholder="Enter Keywords" value='<%=filters==null?"":filters.get("keywords")%>'>
                                    
                                    <label>Complete Date</label>
                                    <input id="completedate" name="completedate" class="filter" type="text" placeholder="Enter Complete Date" value='<%=filters==null?"":filters.get("completedate")%>'>
                    
                                    <label>Place</label>
                                    <input id="place" name="place" class="filter" type="text" placeholder="Enter Place" value='<%=filters==null?"":filters.get("place")%>'>
                                    <input id="edition" name="itemtype" class="filter" type="text" value="<%=type%>" hidden>
            
                                    <button type="submit" form="theses_filter">Apply Filter</button>
                                </div>
                            </form>
                        <%}else if(type.equals("softcopy")){%>
                            <form action="/search/filter" method="Get" id="softcopy_filter">
                                <div class="search_items">
                                    <label>Title</label>
                                    <input id="title" name="title" class="filter" type="text" placeholder="Enter Title" value='<%=filters==null?"":filters.get("title")%>'>
                                
                                    <label>Owner</label>
                                    <input id="owner" name="owner" class="filter" type="text" placeholder="Enter Owner" value='<%=filters==null?"":filters.get("owner")%>'>
                    
                                    <label>Publisher</label>
                                    <input id="publisher" name="publisher" class="filter" type="text" placeholder="Enter Publisher" value='<%=filters==null?"":filters.get("publisher")%>'>
                                    
                                    <label>Category</label>
                                    <input id="category" name="category" class="filter" type="text" placeholder="Enter Category" value='<%=filters==null?"":filters.get("category")%>'>
                                    
                                    <label>Keywords</label>
                                    <input id="keywords" name="keywords" class="filter" type="text" placeholder="Enter Keywords" value='<%=filters==null?"":filters.get("keywords")%>'>
                                    <input id="edition" name="itemtype" class="filter" type="text" value="<%=type%>" hidden>
            
                                    <button type="submit" form="softcopy_filter">Apply Filter</button>
                                </div>
                            </form>
                        <%}%>
                </div>
            <%}%>
        </div>
        <br>

    </section>
</body>