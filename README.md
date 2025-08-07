# CPOO - Desafio - Modelagem e Diagramação de um Componente iPhone

Criação de diagrama e implementação dos módulos telefone, reprodutor musical e navegador de internet para o iPhone 2007


## Campos
### main

| Campo                     | Tipo      | exemplo       | Origem da Informação |
|:--------------------------|:----------|:--------------|----------------------|
| `Wifi`                    | `boolean` | true          | `Usuário`            |
| `Mobile Data`             | `boolean` | true          | `Usuário`            |
|

### Phone

| Campo               | Tipo      | exemplo | Origem da Informação |
|:--------------------|:----------|:--------|----------------------|
| `Phone Status`      | `boolean` | false   | `Aplicação`          |
| `Call Hold`         | `boolean` | true    | `Usuário`            |
| `Action`            | `string`  | Call    | `Aplicação`          |
| `Exit Loop`         | `boolean` | true    | `Aplicação`          |
| `Sound Volume`      | `int`     | 20      | `Usuário`            |
| `Status Conference` | `boolean` | true    | `Usuário`            |    
| `Message`           | `int`     | true    | `Aplicação`          |

### Music Player

| Campo                 | Tipo      | exemplo | Origem da Informação |
|:----------------------|:----------|:--------|----------------------|
| `Music Player Status` | `boolean` | false   | `Usuário`            |
| `Pause`               | `boolean` | true    | `Usuário`            |
| `Mute`                | `boolean` | true    | `Usuário`            |
| `Action`              | `string`  | Play    | `Aplicação`          |
| `Sound Volume`        | `int`     | 20      | `Usuário`            |
| `Music`               | `String`  | Black   | `Usuário`            |

### Web Browser

| Campo                 | Tipo      | exemplo | Origem da Informação |
|:----------------------|:----------|:--------|----------------------|
| `Mute`                | `boolean` | true    | `Usuário`            |
| `Action`              | `string`  | Play    | `Aplicação`          |
| `Sound Volume`        | `int`     | 20      | `Usuário`            |


## Fluxograma

![Link fluxograma](https://github.com/Anderson-G-Silva/Dio_Desafio_Modelando-iPhone/blob/main/Iphone.drawio.png)

## Linguagens utilizadas
- Java Versão 21.0.7

## Referências

- [DIO - Trilha Java básico](https://github.com/digitalinnovationone/trilha-java-basico/blob/main/desafios/poo/README.md)




## Autores

- [@Anderson-G-Silva](https://github.com/Anderson-G-Silva)


