package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.onedelaybloon;

import static druidsurv.ModFile.makeID;

public class OliveBloon extends AbstractEasyCard {
    public final static String ID = makeID("OliveBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public OliveBloon() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.ENEMY);
        baseDamage = 0;
        baseBlock = 5;
        tags.add(CardTags.STARTER_DEFEND);
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.BASIC);
        setBackgroundTexture("druidsurvResources/images/512/bloon_skill.png", "druidsurvResources/images/1024/bloon_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        if (damage > 0)
        {
            addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new onedelaybloon(m, damage), damage, true, AbstractGameAction.AttackEffect.NONE));
        }
        blck();
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}