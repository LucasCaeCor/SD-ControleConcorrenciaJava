📘 SD – Controlo de Concorrência em Java

Este projeto contém a implementação e análise de dois programas Java que utilizam diferentes mecanismos de controlo de concorrência: Semaphore e Lock.
O objetivo é compreender o funcionamento de cada abordagem, observar o comportamento das threads durante a execução e comparar os resultados.

📝 Saídas Obtidas

Durante a execução no ambiente AWS EC2, observaram-se comportamentos diferentes entre os dois programas.
As saídas completas foram usadas para realizar a análise abaixo.


⚖️ Análise Comparativa — Carro.java vs CarroLock.java

Esta secção apresenta a comparação detalhada entre os programas Carro.java, que utiliza Semaphore, e CarroLock.java, que utiliza Lock.

🔶 1. Comportamento do Carro.java (Semaphore)

O Semaphore permite que várias threads acedam a um recurso simultaneamente, até ao limite definido.

✔ Características observadas:

A ordem dos carros a ocupar e libertar vagas foi aleatória.

Várias threads conseguiram ocupar vagas ao mesmo tempo, de forma concorrente.

Não existe fila organizada; as threads disputam o acesso livremente.


Carro #0 ocupou vaga.
Carro #2 ocupou vaga.
Carro #1 ocupou vaga.
Carro #3 ocupou vaga.
Carro #4 ocupou vaga.
...
Carro #6 liberou vaga.
Carro #14 ocupou vaga.
Carro #3 liberou vaga.
Carro #10 ocupou vaga.
...


🔷 2. Comportamento do CarroLock.java (Lock)

O ReentrantLock usado neste programa (provavelmente com fairness ativado) organiza as threads numa fila de espera justa.

✔ Características observadas:

Os carros ocuparam as vagas exatamente na ordem numérica, indicando ordem de chegada.

Acesso mais previsível e controlado.

A libertação das vagas também foi mais organizada.

Carro #0 ocupou vaga.
Carro #1 ocupou vaga.
Carro #2 ocupou vaga.
Carro #3 ocupou vaga.
Carro #4 ocupou vaga.
...
Carro #14 liberou vaga.
Carro #10 liberou vaga.
Carro #8 liberou vaga.
...


(O comportamento mostra claramente que o Lock garante acesso sequencial.)


| Critério                  | Carro.java (Semaphore)                   | CarroLock.java (Lock)                   |
| ------------------------- | ---------------------------------------- | --------------------------------------- |
| Acesso simultâneo         | Permite múltiplas threads ao mesmo tempo | Acesso exclusivo de uma thread          |
| Ordem de execução         | Aleatória                                | Ordenada (fila justa)                   |
| Comportamento das threads | Competição livre                         | Espera organizada                       |
| Uso ideal                 | Recursos limitados, alta concorrência    | Secções críticas, maior previsibilidade |



🧠 4. Conclusão

O Carro.java, usando Semaphore, demonstra concorrência intensa e acesso não determinístico, ideal para partilha de recursos limitados.

O CarroLock.java, usando Lock, apresenta execução ordenada e determinística, garantindo previsibilidade e equidade entre as threads.

A comparação prática entre ambos evidencia como diferentes mecanismos de sincronização têm impacto direto na ordem e segurança do acesso concorrente.
