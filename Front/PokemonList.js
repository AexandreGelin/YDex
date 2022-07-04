import React, { useEffect, useState } from 'react';
import { ActivityIndicator, SafeAreaView, View, StyleSheet, Text, StatusBar, VirtualizedList, Image, ImageBackground, TouchableOpacity } from 'react-native';
import PokeCard from './PokeCard'
import { useNavigation } from '@react-navigation/native';
import {getNameStored} from './storage/NameStorage'

const PokemonList = ({route}) => {
  const [isLoading, setLoading] = useState(true);
  const [data, setData] = useState([]);
  const [username, setUserName] = useState("");
  let pokeData = [];

  const navigation = useNavigation(); 

  const getPokemonList = async () => {
    try {
      const response = await fetch('http://127.0.0.1:8080/pokemons/_all');
      const poke = await response.json();
      poke.forEach(async (pokeDetail) => {
        if(pokeDetail.types.length < 2){
          const pokeObj = {
            id: pokeDetail.id,
            name: pokeDetail.name,
            sprite: pokeDetail.spriteUrl,
            type1: pokeDetail.types[0].name,
            type2: null,
          };
          pokeData.push(pokeObj);
          pokeData.sort((a,b) => { return parseInt(a.id)-parseInt(b.id)})
          setData(pokeData);
        }
        else{
          const pokeObj = {
            id: pokeDetail.id,
            name: pokeDetail.name,
            sprite: pokeDetail.spriteUrl,
            type1: pokeDetail.types[0].name,
            type2: pokeDetail.types[1].name
          };
          pokeData.push(pokeObj);
          pokeData.sort((a,b) => { return parseInt(a.id)-parseInt(b.id)})
          setData(pokeData);
        }
      });
      
    }
     catch (error) {
      console.error(error);
    } finally {
      setLoading(false);
    }
  }

  const setPokedexName = () => {
    const storedUsername = getNameStored();
    
    storedUsername.then((pokedexName) => {
      setUserName(pokedexName)
    })

  } 

  useEffect(() => {
    getPokemonList();
    setPokedexName();
  }, []);

  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.header}>
        <Text style={styles.headerText}>PokéDex de {username}</Text>
      </View>
      
      {isLoading ? <ActivityIndicator/> : (
        <ImageBackground source={require('./assets/background.jpg')} style={styles.background}>
        <VirtualizedList
            data={data}
            initialNumToRender={4}
            renderItem={({ item }) => (
              <PokeCard pokemon={item} navigation={navigation} />
            )} 
            keyExtractor={ item  => item.name}
            getItem={(data, index) => data[index]}
            getItemCount={data => data.length}
          />
        </ImageBackground>
      )}      
    </SafeAreaView>
  );

}
export default PokemonList;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginTop: StatusBar.currentHeight,
  },
  item: {
    backgroundColor: "#D3D3D3",
    height: 150,
    justifyContent: 'flex-start',
    marginVertical: 8,
    marginHorizontal: 16,
    padding: 20,
    flexDirection: 'row',
  },
  title: {
    fontSize: 20,
  },
  sprite: {
    width: 100,
    height: 100,
  },
  type: {
    width: 30,
    height: 30,
  },
  infos: {
    justifyContent: 'center',
  },
  typerow: {
    flexDirection: 'row',
  },
  background: {
    flex: 1,
    justifyContent: 'center',
  },
  captureState: {
    position: 'absolute',
    right: 30,
    alignSelf: 'center'
  },
  hearder: {
    
  },
  headerText: {
    fontSize: 20,
    textAlign: 'center',
  }
});


// https://pokeapi.co/api/v2/pokemon?limit=897