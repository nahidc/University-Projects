using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AudioCanvasController : MonoBehaviour
{
    private static AudioCanvasController instance = null;

    private void Awake()
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
}
