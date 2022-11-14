<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wallz Tour - Alterar Partida</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"         integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="./assets/style/main.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>
<body>
    <header  class="container-fluid d-flex flex-row align-items-center cor-de-fundo-header justify-content-center">
        <div class="container row justify-content-between">
            <div>
                <a href="./index.html"> <img src="./assets/img/logo-leturminha.png" /> </a>
            </div>
            <div class="d-flex align-items-center">
                <nav>
                    <ul class="nav">
                        <li class="nav-item">
                            <a class="nav-link active cor-link" href="./nossoProjeto.html">Como usar</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active cor-link" href="ProfessorMakeAndSearch">Professor</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active cor-link " href="AlunoMakeAndSearch">Aluno</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active cor-link" href="CardMakeAndSearch">Cards</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active cor-link" href="./partidaMemoriaJogo.html">Jogo da Memória</a>
                        </li>
						<li class="nav-item">
                            <a class="nav-link active cor-link aba-selecionada" href="PartidaMemoriaMakeAndSearch">Ver Resultados</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active cor-link" href="./sobre.html">Sobre nós</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </header>
    <main>
    	<section>
 		<div class="container d-flex align-items-center justify-content-center py-3">
    		    <nav>
                    <ul class="nav px-5">
                        <li class="nav-item">
                            <a class="nav-link active cor-link2" href="./cadastroPartidaMemoria.jsp">Novo Cadastro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active cor-link2" href="PartidaMemoriaMakeAndSearch">Lista de Partidas de Jogo da Memória</a>
                        </li>
                    </ul>
                </nav>
               		 <form action="PartidaMemoriaMakeAndSearch" method="GET" class="d-flex">
						<input name="pesquisa" class="form-control me-2" type="search" placeholder="Filtre tempo/jogadas" aria-label="Search">
						<button class="btn search-icon" type="submit"> <i class="bi bi-search"></i> </button>
					</form>
    		</div>
    	</section>
    	<section>
     	   <div class="container">
				<div class="row d-flex align-items-center justify-content-center">
					<div class="col-md-7">
						<hr>
						<h3 class="titulo-aba d-flex justify-content-center">Alterar dados do Partida</h3>
						<hr>
						<form action="PartidaMemoriaUpdate" method="POST">
							<input value="${partidaMemoria.id}" name="id" style="visibility:hidden">
							<input value="${partidaMemoria.idAluno}" name="idAluno" type="number" style="visibility:hidden">
							<div class="py-2">
									<label>Tempo de partida (em segundos)</label>
									<input value="${partidaMemoria.tempoPartida}" name="tempoPartida" min="0" max="99999" type="number" class="form-control" id="floatingInput1"> 
							</div>
							<div class="py-2">
									<label>Quantidade de Jogadas</label>
									<input value="${partidaMemoria.qtdJogadas}" name="qtdJogadas" min="0" max="999" type="number" class="form-control" id="floatingInput2"> 
							</div>									
							<div class="d-flex flex-row align-items-center justify-content-center py-2">
								<button class="btn btn-config" type="submit"> <i class="bi bi-check-lg"></i> Atualizar Cadastro</button>
								<button class="btn btn-config-delete" type="reset"> <i class="bi bi-x-lg"></i> Desfazer Alterações </button>
							</div>
						</form>
						<br>
					</div>
				</div>
			</div>
    	</section>
    </main>
    <footer class="cor-de-fundo-footer">
        <p class="container d-flex flex-row align-items-center">
            Copyright © 2022 Recode. Todos os direitos reservados.
        </p>
    </footer>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>
