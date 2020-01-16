using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class SoundController : MonoBehaviour
{
    public Sprite soundOn;
    public Sprite soundOff;

    public Sprite musicOn;
    public Sprite musicOff;

    public GameObject toggleSoundButton;
    [SerializeField] private SoundManager instance;

    private bool sOn;
    private bool mOn;

    private void Awake()
    {
    

        sOn = true;
        mOn = true;
    }
    
        

    public void toggleSound()
    {
        
        sOn = !sOn;
      
        instance.ToggleSound();
        setSoundIcon();
    }

    void setSoundIcon()
    {
        if (sOn)
        {
            toggleSoundButton.GetComponent<Image>().sprite = soundOn;
        }
        else if (!sOn)
        {
            toggleSoundButton.GetComponent<Image>().sprite = soundOff;
        }
    }

    public void toggleMusic()
    {
        mOn = !mOn;

        instance.ToggleMusic();
        setMusicIcon();
    }

    void setMusicIcon()
    {
        if (mOn)
        {
            toggleSoundButton.GetComponent<Image>().sprite = musicOn;
        }
        else if (!mOn)
        {
            toggleSoundButton.GetComponent<Image>().sprite = musicOff;
        }
    }
}
