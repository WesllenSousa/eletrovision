#erÃªia: http://www.htmlstaff.org/postgresqlmanual/app-pgdump.html
# Emiliano ESB<emilianoeloi@gmail.com>
# C 2005 04 20
# R 2007 04 11[adaptado para o VOL]
#
# VARIAVEIS ##################
export PG_USERNAME="postgres"
export PG_PASSWORD="postgres"
vU="postgres"             # Usuario no PostGreSQL
vBI="/opt/PostgreSQL/9.0/bin/pg_dump" # Diretorio raiz dos binarios do PostGreSQL
vB="sistema"
vR="/"                    # Diretorio raiz
vD="var/bkbanco/"         # Destino do Backup
vPre="basePGSQL"          # Prefixo no nome do arquivo de saida
vE=".backup"              # extencao do arquivo de saida
vH="localhost"            # Host do servidor
vPt="5432"                # Porta do servidor
vC="5"                    # Taxa de compressao do arquivo de 0-9
vAno=`date +%Y` #Ano
vMes=`date +%m` #Mes
vDia=`date +%d` #Dia
vHor=`date +%H` #Hora
vMin=`date +%M` #Min
vCod=`date +%N` #CÃ³o date [date (GNU coreutils) 5.3.0]
vDat="$vDia$vMes$vAno-$vHor$vMin-$vCod"
vA=$vPre"-"$vB"-"$vDat$vE
# VALIDAÃ ##################
# BACKUP #####################
echo "# Gerando backup. Aguarde..."
echo "# Destino: $vR$vD"
echo "# Nome do arquivo: $vA"
$vBI -v -U $vU -h $vH -p $vPt -Z $vC --format=c -b --file=$vR$vD$vA $vB
