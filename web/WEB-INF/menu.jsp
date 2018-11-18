<%-- 
    Document   : menu
    Created on : 7 nov. 2018, 23:55:57
    Author     : jmk
--%>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header"><a class="navbar-brand navbar-link logo" href="#">CartoWeb </a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav navbar-right">
                    <li role="presentation" class="${ (statut == "carto")? 'active' : '' }"><a href="cartoweb?statut=carto">Carto</a></li>
                    <li role="presentation" class="${ (statut == "rech")? 'active' : '' }"><a href="cartoweb?statut=rech">Recherche</a></li>
                    <li role="presentation"><a href="#">A propos</a></li>
                </ul>
            </div>
        </div>
    </nav>
