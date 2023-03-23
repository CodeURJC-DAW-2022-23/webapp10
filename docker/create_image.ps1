Param(
    [String] $name
)



Set-Location ../

Write-Output "Directorio actual cambiado a $PWD"

docker build -t $name -f docker/dockerfile .

docker push $name