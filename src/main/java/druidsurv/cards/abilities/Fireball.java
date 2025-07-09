package druidsurv.cards.abilities;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractPowerCostCard;
import druidsurv.powers.OnFire;

import static druidsurv.ModFile.makeID;

public class Fireball extends AbstractPowerCostCard {
    public final static String ID = makeID("Fireball");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Fireball() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY, CharacterFile.Enums.NEMDRUID_COLOR, "RapidShot_CardArt");
        baseMagicNumber = 6;
        tags.add(druidsurv.cards.cardvars.CardTags.HEROIC);
        retain = true;
        setOrbTexture("druidsurvResources/images/512/bloontonium.png", "druidsurvResources/images/1024/bloontonium.png");
        setBackgroundTexture("druidsurvResources/images/512/hero_skill.png", "druidsurvResources/images/1024/hero_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, new OnFire(m, magicNumber), magicNumber, true, AbstractGameAction.AttackEffect.FIRE));
    }

    /*public void onPlayCard(AbstractCard c, AbstractMonster m) {
        if (c.hasTag(BLOON) && this.cost > 0) {
            this.cost = 0;
        }
    }*/

    @Override
    public void upp() {
        upgradeBaseCost(1);
    }
}