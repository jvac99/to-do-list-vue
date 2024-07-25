<template>
  <p class="text">{{ description }}</p>
</template>

<script lang="ts">
import { ref } from "vue";

export default {
  name: "suspenseTest",
  components: {},
  setup() {
    let description = ref("");
    const getdescription = async () => {
      return await new Promise((resolve) => {
        setTimeout(() => {
          resolve(
            "É um componente que permite renderizar um conteúdo de fallback enquanto aguarda a conclusão do carregamento de um componente assíncrono." +
              " Isso é especialmente útil quando você está carregando partes da sua aplicação de forma dinâmica, como componentes que são carregados assincronamente."
          );
        }, 3000);
      });
    };

    getdescription()
      .then((res) => {
        description.value = res;
        return res;
      })
      .catch((err) => console.log(err));

    return { description };
  },
};
</script>
