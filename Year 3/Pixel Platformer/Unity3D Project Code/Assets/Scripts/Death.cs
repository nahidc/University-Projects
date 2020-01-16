using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Death : MonoBehaviour
{
    [SerializeField] private Transform spawnPoint;
    public AudioClip deathSound;
    
    void OnCollisionEnter2D(Collision2D collision)
    {
        if(collision.gameObject.tag == "Player")
        {
            SoundManager.instance.PlaySingle(deathSound);
            collision.gameObject.transform.position = spawnPoint.position;
        }       
    }
} 
