<template>
    <transition class="modal col-md-12 col-sm-12 col-xs-12">
        <div class="modal-mask">
            <div class="modal-wrapper">
                <div class="modal-container">
                    <h3>Click Image To Select Avatar</h3>
                    <div class="modal-body col-md-12 col-sm-12 col-xs-12">
                        <div v-bind:key="image.id" v-for="image in avatarImages" >
                            <div class="image-container col-md-4 col-sm-4 col-xs-6" >
                                <div class="image">
                                    <AvatarModalView :image="image.img"
                                                      v-on:selected-avatar-image="selectedAvatarImage"
                                                      v-on:show-avatar-modal="$emit('show-avatar-modal')" />
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="modal-button-container ">
                            <button class="modal-close-button"
                                    @click="$emit('show-avatar-modal')">
                                close
                            </button>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </transition>
</template>

<script>
    import AvatarModalView from './AvatarModalView';

    export default {
        name: 'AvatarModalComponent',
        components: {
            AvatarModalView
        },
        props: [
            'avatarImages'
        ],
        methods: {
            selectedAvatarImage(image){
                this.$store.commit( 'setAvatarImage', image);
                this.$emit('show-avatar-modal')
            }
        }
    }

</script>

<style scoped>
    .modal-mask {
        position: fixed;
        z-index: 9998;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, .5);
        display: table;
        transition: opacity .3s ease;
    }

    .modal-wrapper {
        display: table-cell;
        vertical-align: middle;
    }

    .modal-container {
        width: 70%;
        height: 70vh;
        margin: auto auto;
        padding: 20px 30px;
        border-radius: 2px;
        box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
        transition: all .3s ease;
        font-family: Helvetica, Arial, sans-serif;
        background: #5D5D5D;
    }
    @media screen and (min-width: 765px) and (max-width: 1000px){
        .modal-container {
            width: 50%;
            height: 50vh;
            margin-top: -5%;
        }
    }
    @media screen and (min-width: 1000px){
        .modal-container {
            width: 50%;
            height: 50vh;
        }
    }
    @media screen and (min-width: 1200px){
        .modal-container {
            width: 50%;
            height: 50vh;
            margin-top: -5%;
        }
    }

    .modal-header h3 {
        margin-top: 0;
        color: #42b983;
    }

    .modal-body {
        margin: 20px 0;
    }

    @media screen and (max-width: 470px){
        .image-container {
            padding-left: 0 !important;
        }
    }
    .image {
        padding: 2%
    }

    .modal-button-container {
        margin-left: auto;
        margin-right: auto;
    }

    .modal-close-button {
        width: 30%;
        height: 5vh;
        font-size: 15px;
        color:black;
    }


    /*
     * The following styles are auto-applied to elements with
     * transition="modal" when their visibility is toggled
     * by Vue.js.
     *
     * You can easily play with the modal transition by editing
     * these styles.
     */

    .modal-enter {
        opacity: 0;
    }

    .modal-leave-active {
        opacity: 0;
    }

    .modal-enter .modal-container,
    .modal-leave-active .modal-container {
        -webkit-transform: scale(1.1);
        transform: scale(1.1);
    }
</style>
