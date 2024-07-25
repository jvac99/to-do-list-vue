<template>
  <div class="main">
    <section>
      <h1>Vue 3</h1>
      <h5>João Victor Aquino Correia</h5>
    </section>
    <section>
      <h1>Teleport</h1>
      <p class="text">
        É um componente embutido que permite-nos "teletransportar" uma parte de
        um modelo de marcação do componente para um nó de DOM que existe fora da
        hierarquia do DOM deste componente.
      </p>
      <div class="buttons">
        <CommonModal />
        <button @click="showModal = true">Show Modal</button>
        <Modal :show="showModal" @close="showModal = false" />
      </div>
    </section>
    <section>
      <h1>Fragments</h1>
      <textarea readonly rows="10" cols="40">
        <template>
          <header>...</header>
          <main>...</main>
          <footer>...</footer>
        </template>
      </textarea>
    </section>
    <section>
      <h1>Declarações condionais</h1>
      <ul>
        <li>v-show</li>
        <li>v-if</li>
        <li>v-else-if</li>
        <li>v-else</li>
        <h1 v-text="Olá"></h1>
      </ul>
      <p v-show="show">Animal List</p>
      <ul v-show="show" v-for="(animal, index) in animais" :key="index">
        <li v-if="animal.show && animal.type === 'cat'">
          Cat: {{ animal.name }}
        </li>
        <li v-else-if="animal.show && animal.type === 'dog'">
          Dog: {{ animal.name }}
        </li>
        <li v-else>Pig: {{ animal.name }}</li>
      </ul>
      <textarea readonly rows="10" cols="40">
          <ul v-show="show"
          v-for="(animal, index) in animais" :key="index">
            <li v-if="animal.show && animal.type === 'cat'">
              Cat: { { animal.name } }
            </li>
            <li v-else-if="animal.show && animal.type === 'dog'">
              Dog: { { animal.name } }
            </li>
            <li v-else>
              Pig: { { animal.name } }
            </li>
          </ul>
      </textarea>
    </section>
    <section>
      <h1>Slots</h1>
      <slots>
        <template v-slot:header>
          <ul>
            <li>Slots Nomeados (Named Slots)</li>
          </ul>
        </template>
        <hr />
        <ul>
          <li>Slots Padrão (Default Slots)</li>
        </ul>
        <template #footer="{ test }">
          <hr />
          <ul>
            <li>Slots Escopados (Scoped Slots)</li>
            <li class="text">Aqui: {{ test }}</li>
          </ul>
        </template>
      </slots>
    </section>
    <section>
      <h1>Options API VS Composition API</h1>
      <CompositionAPIView />
    </section>
    <section>
      <h1>Suspense</h1>
      <Suspense>
        <template #default>
          <suspense-test />
        </template>
        <template #fallback> <h5>Loading...</h5> </template>
      </Suspense>
    </section>
  </div>
</template>

<script lang="ts">
import CompositionAPIView from "./CompositionAPIView.vue";
import CommonModal from "../components/CommonModal.vue";
import Modal from "../components/Modal.vue";
import SuspenseTest from "../components/SuspenseTest.vue";
import Slots from "../components/Slots.vue";

export default {
  name: "TechTalk",
  components: { CompositionAPIView, Modal, CommonModal, SuspenseTest, Slots },
  data() {
    return {
      show: true as Boolean,
      showModal: false as Boolean,
      animais: [
        { name: "vivi", show: true, type: "cat" },
        { name: "Bob", show: true, type: "dog" },
        { name: "Peppa", show: true, type: "pig" },
      ] as Array<Object>,
      greenColor: "green" as String,
    };
  },
  // Lifecycle
  beforeMount() {
    console.log("beforeMount OptionAPIView");
  },
  mounted() {
    console.log("mount OptionAPIView");
  },
  beforeCreate() {
    console.log("beforeCreate OptionAPIView");
  },
  created() {
    console.log("created OptionAPIView");
  },
  beforeUpdate() {
    console.log("beforeUpdate OptionAPIView");
  },
  updated() {
    console.log("updated OptionAPIView");
  },
  beforeUnmount() {
    console.log("beforeUnmount OptionAPIView");
  },
  unmounted() {
    console.log("unmounted OptionAPIView");
  },
};
</script>

<style scoped>
.main {
  width: 60%;
  height: 100%;
  margin: 0 auto;
}

.main section {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100;
  height: 100vh;
  gap: 15px;
}

h1 {
  color: #42b983;
}

h5 {
  color: #ccc;
}

.text {
  width: 50%;
}

p,
li {
  font-size: 18px;
  color: #666;
}

textarea {
  width: 50%;
  height: 30%;
  padding: 10px;
  font-family: "Courier New", Courier, monospace;
  font-size: 14px;
  background-color: #282c34;
  color: v-bind(greenColor);
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  resize: vertical;
}

button {
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
}

.buttons {
  display: flex;
  gap: 10px;
}

.d-flex {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
