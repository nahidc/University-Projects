using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SoundManager : MonoBehaviour
{
    public AudioSource efxSource;
    public AudioSource musicSource;
    public static SoundManager instance = null;

    void Awake()
    {
        if (instance == null)
        {
            instance = this;
        }
        else
        {
            Object.Destroy(gameObject);
        }
        DontDestroyOnLoad(instance);
    }

 
    public void PlaySingle(AudioClip clip)
    {
        efxSource.clip = clip;
        efxSource.Play();
    }

    public void ToggleSound() ////true = muted, false = unmuted
    {
        
        efxSource.mute = !efxSource.mute;
        

    }

    public void ToggleMusic()
    {
        musicSource.mute = !musicSource.mute; //true = muted, false = unmuted
    }
}
